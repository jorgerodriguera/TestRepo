

public class GenerateRandom {

	
	
	public static void main(String[] args) {
		
		
		try {
			int rnd = generate(500);
			System.out.println(rnd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
public static int generate(int max) throws Exception {
		
		if (max <= 0) {
			throw new Exception("Number must be greater than 0!");
		}else if (max > 1000000) {
			throw new Exception ("Number must be lower than 1 000 000!");
		}
					
		if (max == 1) {
			return 0;
		}
				
		//this is the max possible value
		int maxPosibleValue = max-1;
						  
		//This is the length of the max possible value in binary, gonna use it to get our random bin number
		int binaryLength = Integer.toBinaryString(maxPosibleValue).length();

		Integer rndResult = null;
		while (rndResult == null || rndResult > max) {
			String rndBin = getRandomBinString(binaryLength);
			rndResult = Integer.parseInt(rndBin, 2);
		}
		
		return rndResult;
	}


	
	/**
	 * This is the provided flip method, our only source of randomness
	 * @return
	 */
	public static boolean flip() {
		
		return Math.random() >= 0.5;
	}
	
	
	/**
	 * Generate a random string using the flip method
	 * @param length
	 * @return
	 */
	public static String getRandomBinString(int length) {
		StringBuilder binStr = new StringBuilder();
	    for (int i=0; i<length; i++) {
	      binStr.append( flip() ? "1" : "0");
	    }
	    
	    return binStr.toString();
	}
	
	
	
}
