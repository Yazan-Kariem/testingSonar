package Sakancom.loginFeature;
import java.util.Scanner;
import java.util.logging.Logger;

public class SakancomApplication{

    public static void main(String[] args) {
       Logger logger = Logger.getLogger(SakancomApplication.class.getName());
        String line="_____________________________________________";
        while(true){
logger.info(line);
            logger.info("Choose from the following ");
            logger.info("1-Login");
            logger.info("2-Signup");
            logger.info("The Value : ");
            Scanner input = new Scanner(System.in);
            int LoginOrSignUp = 0;
            LoginOrSignUp = input.nextInt();
            logger.info(line);
            if (LoginOrSignUp == 1) {
                logger.info("\n******* Login Page *******\n");
                loginEntity in=new loginEntity();

                Scanner input1 = new Scanner(System.in);
                logger.info("Enter User Name : ");
                in.UserName = input1.nextLine();
                logger.info("Enter the Password : ");
                in.Password = input1.nextLine();
                String role= in.checkValues(in.UserName,in.Password);


                if(role.equals("tenant")){
while(true){

    logger.info(line);
    logger.info("Choose from the following");
    logger.info("1-View the available housing");
    logger.info("2-Furniture");
    logger.info("3-Control Panel");
    logger.info("4-ShowLivedIn");
    logger.info("5-Sign out");
    Scanner input2=new Scanner(System.in);
    int choose=input2.nextInt();
    logger.info(line);
    if(choose==1){
        housingEntity e=new housingEntity();
       int avb= e.showAvailable();
       if(avb>1){
           logger.info("do you want to book  accommodation? (Yes or No)");
        Scanner inp=new Scanner(System.in);
        String YN=new String();
        YN=inp.nextLine();
        if(YN.equals("Yes")){
            logger.info("Enter house ID : ");
            Scanner id = new Scanner(System.in);
            String ID = id.nextLine();
            e.booking(ID,in.UserName);

        }}
    }
if(choose==2) {
    while (true) {
        logger.info(line);
        logger.info("Choose from the following");
        logger.info("1-View the available Furnitures");
        logger.info("2-Add Furnitures");
        logger.info("3-Sell Furnitures");
        logger.info("4-Back");
        Scanner inp = new Scanner(System.in);
        int ch = inp.nextInt();
        logger.info(line);
        Furniture o = new Furniture();
        if (ch == 1) {
            o.displayFurniture(in.UserName);

        } else if (ch == 2) {
            Scanner inp1 = new Scanner(System.in);
            logger.info("Enter Picture : ");
            o.picture = inp1.nextLine();
            logger.info("Enter Description : ");
            o.description = inp1.nextLine();
            logger.info("Enter Price : ");
            o.price = inp1.nextLine();
            logger.info("Enter ID : ");
            o.id = inp1.nextLine();
            o.selled = "No";
            o.addFurniture(in.UserName, o.picture, o.description, o.price, o.id, o.selled);

        } else if (ch == 3) {
            Scanner inp1 = new Scanner(System.in);
            logger.info("Enter ID to sell: ");
            o.id = inp1.nextLine();
            o.sellFurniture(o.id, in.UserName);

        }


        else if (ch == 4) {
            break;
        }

    }
} else if (choose==3) {
ControlPanel e=new ControlPanel();
e.displayControlPanel(in.UserName);
}
else if(choose==4){
    logger.info("Enter House id you want to show:");
    Scanner in1=new Scanner(System.in);
    String id=in1.nextLine();
    showLivedIn e=new showLivedIn();
    e.displayLived(id);
}

else if (choose==5) {
    break;
}
}

                }
                else if(role.equals("owner")){
                }
                else if (role.equals("admin")) {

                }

                logger.info(line);
            }

            else if (LoginOrSignUp==2) {

            }
        }
    }
}
