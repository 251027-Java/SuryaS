public class HolidayArt {
    public static void main(String[] args){
        int height = 5;
        int starCount = 1;
        if (args.length > 0) {
            height = Integer.parseInt(args[0]);
        }
        int spaceCount = height-1;
        for(int i = 1; i <= height; i++){
            System.out.print(" ".repeat(spaceCount));
            System.out.print("*".repeat(starCount));
            System.out.println(" ".repeat(spaceCount));
            starCount+=2;
            spaceCount--;
        }

    }
}
