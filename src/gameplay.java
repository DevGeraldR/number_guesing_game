
import java.util.Scanner;

public class gameplay {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int ans;
		int guess = 0;
		int chances = 10;
		int n = 100;
		boolean found;
		
		int numbers[] = new int[101];
		for(int i=0; i<=n; i++) {
			numbers[i] = i;
		}
		
		System.out.println("This is a number guessing game!!!\nA number is chosen between 0 to 100\nYou have 10 chances to guess the right number\n");
			
		System.out.println("Player 1: Enter the answer");
		ans = scan.nextInt(); 
		found = search(numbers, n, ans);
		
		if(found) {
		System.out.println("Player 2: Guess the number");
		guess = scan.nextInt();
		chances-=1;
		
			while(chances != 0) {
				if (guess == ans) {
					System.out.println("You got it right!");
					break;
				} else if (guess < ans){
					System.out.println("Your answer is too low! (Chances:" + chances + ')');
				} else {
					System.out.println("Your answer is too high! (Chances:" + chances + ')');
				}
				guess = scan.nextInt();
				chances -= 1;
			}
			if(chances == 0) {
				System.out.println("Game over! The answer is: " + ans);
			}
		} else {
			System.out.println("The number should be between 0 to 100");
		}
		scan.close();
	}
	
	static boolean search(int arr[], int n, int number) {
		int fnum, lnum, middle;
		fnum = 0;
		lnum = n-1;
		while(fnum <= lnum) {
			middle = (fnum + lnum)/2;
			if(number == arr[middle]){
				return true;
			} else if(number > arr[middle]) {
				fnum = middle + 1;
			} else {
				lnum = middle - 1;
			}
		}
		return false;
	}

}
