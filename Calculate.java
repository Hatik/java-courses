public class Calculate {
	public static void main(String[] arg){
		System.out.println("Calculate");
		int first = Integer.valueOf(arg[0]);
		int second = Integer.valueOf(arg[1]);

		int sum = first + second;
        int difference = first - second;
        float division = (float) first /(float) second;
        int multiple = first * second;
        int result = power(first,second);
		System.out.println("Sum: " + sum + "\nDifference: " + difference + "\nDivision: " + division + "\nMultiple: "
                + multiple + "\nPower: " + result);
	}
    public static int power(int first, int second) {
        if (second == 0)
            return 1;
        else
            return first * power(first, second - 1);
    }

}