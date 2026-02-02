import java.util.Random;

public class House {
    public MouseFood[] mousePantry;
    public String message = "A7#q 9mA$%2mn!!8my@4mt^6mh&1mi*3mn(0mgZ9m 4wfymt@7mh# 5ma$2mt!8m mmma%3mk^4me&6ms*1m Q12mm &2-me#7m mc$9mu!5mt@8m 6hM.mt^4mh&6me *3m R7mc@2mh#9me$5me!832ms^4me&6m.";

    public House() {
        mousePantry = new MouseFood[18];
        Random rand = new Random();

        for(int i=0; i< mousePantry.length; i++){
            int serving = rand.nextInt(200) + 1;
            int smell = rand.nextInt(491) + 10;
            mousePantry[i] = new MouseFood(serving, smell);
        }

        displayMousePantry();
        System.out.println("Two mouse food with the same servings?:" + checkServings());
        System.out.println("The decoded message was: " + decipher(message));
        makeSmells();
        displayMousePantry();
    }

    public void displayMousePantry(){
        for(int i=0; i< mousePantry.length; i++){
            mousePantry[i].printInfo();
        }
    }

    public boolean checkServings(){
        for(int i=0; i< mousePantry.length; i++){
            for(int j=i+1; j< mousePantry.length; j++){
                if(mousePantry[i].getServings() == mousePantry[j].getServings()){
                    return true;
                }
            }
        }

        return false;
    }

    public String decipher(String text){
        String decoded = "";
        int i = 0;

        while(i<text.length()){
            if(text.charAt(i) == 'm'){
                decoded += text.charAt(i+1);
                i = i + 2;
            }
            else {
                i++;
            }

        }

        return decoded;
    }

    public void makeSmells(){
        Random rand = new Random();

        for(int i=0; i< mousePantry.length; i++){
            int smell = rand.nextInt(491) + 10;
            boolean unique;
            unique = false;

            while(!unique){
                unique = true;

                for(int j=0; j< mousePantry.length; j++) {
                    if (mousePantry[j].getSmellFactor() == smell) {
                        unique = false;
                    }
                }

                if(!unique){
                    smell = rand.nextInt(491) + 10;
                }

            }

            mousePantry[i] = new MouseFood(mousePantry[i].getServings(), smell);
        }
    }

    public static void main(String[] args) {
        House mine = new House();
        System.out.println("Hello, mouse! Get out of my house!");
    }



}
