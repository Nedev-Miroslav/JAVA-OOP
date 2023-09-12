package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
       Service service = null;

       if(type.equals("MainService")) {
           service = new MainService(name);
       } else if (type.equals("SecondaryService")) {
           service = new SecondaryService(name);
       } else {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
       }
         services.add(service);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement = null;

        if(type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        } else if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);

        }

        supplements.addSupplement(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }


    @Override
    public String supplementForService(String serviceName, String supplementType) {
            Supplement supplement = this.supplements.findFirst(supplementType);
            if (supplement == null){
                throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
            }

            Service service = getServiceByName(serviceName);
            service.addSupplement(supplement);
            this.supplements.removeSupplement(supplement);


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);

    }

    private Service getServiceByName(String serviceName){
         return this.services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .findFirst()
                .get();
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot = null;

        if(robotType.equals("MaleRobot")){
            robot = new MaleRobot(robotName, robotKind, price);
        } else if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }

        Service service = getServiceByName(serviceName);
        boolean checkFemale = robotType.equals("FemaleRobot") && service.getClass().getSimpleName().equals("SecondaryService");
        boolean checkMale = robotType.equals("MaleRobot") && service.getClass().getSimpleName().equals("MainService");

        if (checkFemale || checkMale){
            service.addRobot(robot);
        } else {
            return ConstantMessages.UNSUITABLE_SERVICE;
        }



        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = getServiceByName(serviceName);
        service.feeding();

        return String.format(ConstantMessages.FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = getServiceByName(serviceName);
        double robotSum = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double supplementsSum = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();

        double allPriceSum = robotSum + supplementsSum;

        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, allPriceSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Service service : services) {
            sb.append(service.getStatistics());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
