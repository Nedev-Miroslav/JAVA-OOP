package petStore;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PetStoreTest {

    @Test
    public void testCreatePetstoreAndAddAnimal(){
        PetStore petStore = new PetStore();
        Animal animalCat = new Animal("cat", 5, 30.5);
        Animal animalDog = new Animal("dog", 25, 130.5);
        petStore.addAnimal(animalCat);
        assertEquals(1, petStore.getCount());
        petStore.addAnimal(animalDog);
        assertEquals(2, petStore.getCount());

        assertEquals(animalCat, petStore.getAnimals().get(0));

    }

    @Test
    public void testCreateAnimal(){
        PetStore petStore = new PetStore();
        Animal animalCat = new Animal("cat", 5, 30.5);
        animalCat.setAge(3);

        petStore.addAnimal(animalCat);
        assertEquals("cat", animalCat.getSpecie());
        assertEquals(5, animalCat.getMaxKilograms());
        assertEquals(30.5, animalCat.getPrice(), 0.00);
        assertEquals(3, animalCat.getAge());


    }

    @Test
    public void testGetPetWithMaxKg(){
        PetStore petStore = new PetStore();
        Animal animalCat = new Animal("cat", 5, 30.5);
        Animal animalDog = new Animal("dog", 25, 130.5);
        Animal animalDog2 = new Animal("dog", 30, 150.5);

        petStore.addAnimal(animalCat);
        petStore.addAnimal(animalDog);
        petStore.addAnimal(animalDog2);

        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(20);
        assertEquals(animalDog, animals.get(0));
        assertEquals(animalDog2, animals.get(1));

    }

    @Test (expected =  IllegalArgumentException.class)
    public void testAddNullPet(){
        PetStore petStore = new PetStore();
        Animal animal = null;
        petStore.addAnimal(animal);
    }

    @Test
    public void testGetMostExpensivePet(){
        PetStore petStore = new PetStore();
        Animal animalCat = new Animal("cat", 5, 30.5);
        Animal animalDog = new Animal("dog", 25, 130.5);
        Animal animalDog2 = new Animal("dog", 30, 150.5);

        petStore.addAnimal(animalCat);
        petStore.addAnimal(animalDog);
        petStore.addAnimal(animalDog2);

        Animal animal = petStore.getTheMostExpensiveAnimal();
        assertEquals(animalDog2, animal);


    }

    @Test
    public void testFindAnimalBySpecie(){
        PetStore petStore = new PetStore();
        Animal animalCat = new Animal("cat", 5, 30.5);
        Animal animalDog = new Animal("dog", 25, 130.5);
        Animal animalDog2 = new Animal("dog", 30, 150.5);

        petStore.addAnimal(animalCat);
        petStore.addAnimal(animalDog);
        petStore.addAnimal(animalDog2);

        List<Animal> animals = petStore.findAllAnimalBySpecie("dog");
        assertEquals(animalDog, animals.get(0));
        assertEquals(animalDog2, animals.get(1));
    }



}