package W04InterfacesAndAbstraction.P02CarShopExtend;

import java.io.Serializable;

public interface Car extends Serializable {
    public Integer TIRES = 4;


    public String getModel();
    public String getColor();
    public Integer getHorsePower();
    public String countryProduced();
}
