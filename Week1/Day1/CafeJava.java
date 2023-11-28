public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 11.5;
        double lattePrice = 7.5;
        double cappucinoPrice = 5.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if(!isReadyOrder2){
            System.out.println("Not ready");
        } else {
            System.out.println("Order ready\nTotal is: " + cappucinoPrice);
        }
        
        System.out.println("Total is: " + (2 * lattePrice));
        if(isReadyOrder3){
            System.out.println("ready");
        } else {
            System.out.println("not ready");
        }

        // Jimmy owes: coffee - latte
        System.out.println("Jimmy owes: " + (lattePrice - dripCoffeePrice));

    }
}