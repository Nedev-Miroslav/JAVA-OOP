package gifts;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class GiftFactoryTest {

    @Test
    public void testCreateGiftFactoryAndAddGift() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("car", 100);
        assertEquals(0, giftFactory.getCount());
        giftFactory.createGift(gift);


    }

    @Test
    public void testCreateGift() {
        Gift gift = new Gift("car", 100);
        assertEquals("car", gift.getType());
        assertEquals(100, gift.getMagic(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAlreadyExistGift() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("car", 100);
        Gift gift1 = new Gift("car", 100);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift1);

    }

    @Test
    public void testRemoveGift() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("car", 100);
        giftFactory.createGift(gift);
        assertEquals(1, giftFactory.getCount());
        giftFactory.removeGift("car");
        assertEquals(0, giftFactory.getCount());

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNotExistGift() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("car", 100);
        giftFactory.createGift(gift);
        giftFactory.removeGift(null);


    }

    @Test
    public void testGetMinMagic(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("car", 100);
        Gift gift2 = new Gift("plane", 1000);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        Gift presentWithLeastMagic = giftFactory.getPresentWithLeastMagic();
        assertEquals(gift1, presentWithLeastMagic);

    }

    @Test
    public void testGetGiftWithGivenName(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("car", 100);
        Gift gift2 = new Gift("plane", 1000);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        Gift car = giftFactory.getPresent("car");
        assertEquals(gift1, car);

    }

    @Test
    public void testGetPresents(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("car", 100);
        Gift gift2 = new Gift("plane", 1000);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        Collection<Gift> presents = giftFactory.getPresents();
        assertEquals(2, presents.size());



    }


}