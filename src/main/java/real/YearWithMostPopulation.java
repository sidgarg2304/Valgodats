package real;

/**
 * given array of birth years and array of death years, find year with most
 * population between 1900-2000 years
 * 
 * @author vkotha
 *
 */
public class YearWithMostPopulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// {1910, 1920, 1940}
	// {1940,1980,2000}
	int yearWithMostPopulation(int[] births, int[] deaths) {
		int[] count = new int[101];

		for (int i = 0; i < births.length; i++) {
			count[births[i] - 1900]++;
			count[deaths[i] - 1900]--;
		}
		
		// 1  1   0 -1  -1
		// 10 20 40 80 100
		

		int population = count[0];
		int maxPopYear = 0;
		int maxPop = count[0];

		for (int i = 1; i < 101; i++) {
			population += count[i];
			if (population > maxPop) {
				maxPop = population;
				maxPopYear = i;
			}
		}
		return maxPopYear;

	}

}
