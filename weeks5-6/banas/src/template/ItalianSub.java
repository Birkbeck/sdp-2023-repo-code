package template;


public class ItalianSub extends Sub {

    private final String[] meatUsed = {"Salami", "Pepperoni", "Capicola Ham"};
    private final String[] cheeseUsed = {"Provolone"};
    private final String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
    private final String[] condimentsUsed = {"Oil", "Vinegar"};

    @Override
    public void addMeat() {
        System.out.print("Adding the Meat: ");
        for (String meat : meatUsed) {
            System.out.print(meat + " ");
        }
    }

    @Override
    public void addCheese() {
        System.out.print("Adding the Cheese: ");
        for (String cheese : cheeseUsed) {
            System.out.print(cheese + " ");
        }
    }

    @Override
    public void addVegetables() {
        System.out.print("Adding the Vegetables: ");
        for (String vegetable : veggiesUsed) {
            System.out.print(vegetable + " ");
        }
    }

    @Override
    public void addCondiments() {
        System.out.print("Adding the Condiments: ");
        for (String condiment : condimentsUsed) {
            System.out.print(condiment + " ");
        }
    }
}

	/*
    public void makeSandwich(){
		cutBun();
		addMeat();
		addCheese();
		addVegetables();
		addCondiments();
		wrapTheHoagie();
	}

	public void cutBun(){
		System.out.println("The Hoagie is Cut");
	}

	public void addMeat(){
		System.out.println("Add Salami, Pepperoni and Capicola ham");
	}

	public void addCheese(){
		System.out.println("Add Provolone");
	}

	public void addVegetables(){
		System.out.println("Add Lettuce, Tomatoes, Onions and Sweet Peppers");
	}

	public void addCondiments(){
		System.out.println("Add Oil and Vinegar");
	}

	public void wrapTheHoagie(){
		System.out.println("Wrap the Hoagie");
	}
}
	*/