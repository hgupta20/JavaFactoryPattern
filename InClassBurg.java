public class InClassBurg {
    public static void main(String[] args) {
        Burger order = new Avocado(new FriedEgg(new GrilledOnions(BurgerFactory.getBurger("blb"))));
        double cost = order.makeBurger();
        System.out.println("Total: $" + cost);

        /*
        // Basic Burger
        System.out.println("Testing all the burgers....");
        Burger order1 = new Avocado(new FriedEgg(new GrilledOnions(BurgerFactory.getBurger("bb"))));
        double cost1 = order1.makeBurger();
        System.out.println("Total: $" + cost1);
        // Salmon Burger
        Burger order2 = new Avocado(new FriedEgg(new GrilledOnions(BurgerFactory.getBurger("sb"))));
        double cost2 = order2.makeBurger();
        System.out.println("Total: $" + cost2);
        // grassfed burger
        Burger order3 = new Avocado(new FriedEgg(new GrilledOnions(BurgerFactory.getBurger("gf"))));
        double cost3 = order3.makeBurger();
        System.out.println("Total: $" + cost3);
        // blackbean Burger
        Burger order4 = new Avocado(new FriedEgg(new GrilledOnions(BurgerFactory.getBurger("blb"))));
        double cost4 = order4.makeBurger();
        System.out.println("Total: $" + cost4);
        // Invalid option
        Burger order5 = new Avocado(new FriedEgg(new GrilledOnions(BurgerFactory.getBurger("blwdfcb"))));
        double cost5 = order5.makeBurger();
        System.out.println("Total: $" + cost5);
        */

    }

}
interface Burger{
    public double makeBurger();
}
class BasicBurger implements Burger{
    private double cost = 6.50;
    @Override
    public double makeBurger() {
        System.out.println("Basic CheeseBurger: $6.50");
        return cost;
    }

}
class SalmonBurger implements Burger{
    private double cost = 8.50;
    @Override
    public double makeBurger() {
        System.out.println("Salmon Burger: $8.50");
        return cost;
    }

}
class GrassfedBurger implements Burger{
    private double cost = 10.50;
    @Override
    public double makeBurger() {
        System.out.println("Grassfed Burger: $10.50");
        return cost;
    }

}
class BlackbeanBurger implements Burger{
    private double cost = 12.50;
    @Override
    public double makeBurger() {
        System.out.println("Black Bean Burger: $12.50");
        return cost;
    }

}
class BurgerFactory {
    public static Burger getBurger(String name) {
        if(name.equals("sb")){
            return new SalmonBurger();
        }
        else if(name.equals("gf")){
            return new GrassfedBurger();
        }
        else if (name.equals("blb")){
            return new BlackbeanBurger();
        }
        else if (name.equals("bb")){
            return new BasicBurger();
        }
        else{
            System.out.println("Invalid Option: returning a Basic Burger");
            return new BasicBurger();
        }
    }
}
abstract class BurgerDecorator implements Burger{
    protected Burger specialBurger;
    public BurgerDecorator(Burger specialBurger){
        this.specialBurger = specialBurger;
    }
    public double makeCoffee(){
        return specialBurger.makeBurger();
    }
}


class GrilledOnions extends BurgerDecorator{
    private double cost = 1.00;

    public GrilledOnions(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addGrilledOnions();
    }

    private double addGrilledOnions(){
        System.out.println(" + Grilled Onions: $1.00");
        return cost;
    }
}
class FriedEgg extends BurgerDecorator{
    private double cost = 1.50;

    public FriedEgg(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addFriedEgg();
    }

    private double addFriedEgg(){
        System.out.println(" + Fried Egg: $1.50");
        return cost;
    }
}

class Bacon extends BurgerDecorator{
    private double cost = 1.50;

    public Bacon(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addBacon();
    }

    private double addBacon(){
        System.out.println(" + Bacon: $1.50");
        return cost;
    }
}

class Avocado extends BurgerDecorator{
    private double cost = .75;

    public Avocado(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addAvocado();
    }

    private double addAvocado(){
        System.out.println(" + Avocado: $.75");
        return cost;
    }
}

class  RoastedPeppers extends BurgerDecorator{
    private double cost = 1.50;

    public  RoastedPeppers(Burger specialBurger){
        super(specialBurger);

    }

    public double makeBurger(){
        return specialBurger.makeBurger() + addRoastedPeppers();
    }

    private double addRoastedPeppers(){
        System.out.println(" + Roasted Peppers: $1.50");
        return cost;
    }
}


