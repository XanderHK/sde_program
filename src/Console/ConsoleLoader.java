package Console;

/**
 * Class ConsoleFacade
 */
public class ConsoleLoader {

    /**
     * Properties
     */
    private int loadingNumber;

    /**
     * Constructor
     */
    public ConsoleLoader() {
        loadingNumber = 0;
    }

    public void loading(){
        loadingNumber++;
        if(loadingNumber == 1){
            System.out.println("Loading…\n" +
                    "█▒▒▒▒▒▒▒▒▒");
        }

        if (loadingNumber >= 1 && loadingNumber <= 2){
            System.out.println("10%\n" +
                    "███▒▒▒▒▒▒▒");
            continueLoading();
        } else if(loadingNumber >= 3 && loadingNumber <= 4) {
            System.out.println("30%\n" +
                    "█████▒▒▒▒▒");
            continueLoading();
        } else if(loadingNumber >= 5 && loadingNumber <= 6) {
            System.out.println("50%\n" +
                    "██████▒▒▒▒");
            continueLoading();
        } else if(loadingNumber >= 7 && loadingNumber <= 8) {
            System.out.println("70%\n" +
                    "███████▒▒");
            continueLoading();
        } else if (loadingNumber == 9){
            System.out.println("100%\n" +
                    "██████████");
        }
    }

    public void continueLoading() {
        loadingNumber++;
        loading();
    }



}
