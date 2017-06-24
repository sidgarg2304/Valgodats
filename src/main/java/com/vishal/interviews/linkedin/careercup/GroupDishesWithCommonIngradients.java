package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * Suppose you have a list of Dishes, where each dish is associated with a list of ingredients. Group together dishes with common ingredients. 

E.g: 
Input: 
"Pasta" -> ["Tomato Sauce", "Onions", "Garlic"] 
"Chicken Curry" --> ["Chicken", "Curry Sauce"] 
"Fried Rice" --> ["Rice", "Onions", "Nuts"] 
"Salad" --> ["Spinach", "Nuts"] 
"Sandwich" --> ["Cheese", "Bread"] 
"Quesadilla" --> ["Chicken", "Cheese"] 

Output: ("Pasta", "Fried Rice") ("Fried Rice, "Salad") , ("Chicken Curry", "Quesadilla") ("Sandwich", "Quesadilla") 

Follow up: What is the time and space complexity?
 *
 */
public class GroupDishesWithCommonIngradients {

	public static void main(String[] args) {

		Map<String, String[]> dishes = new HashMap<>();

		dishes.put("Pasta", new String[] {"Tomato Sauce", "Onions", "Garlic"});
		dishes.put("Chicken Curry", new String[] {"Chicken", "Curry Sauce"});
		dishes.put("Fried Rice", new String[] {"Rice", "Onions", "Nuts"});
		dishes.put("Salad", new String[] {"Spinach", "Nuts"});
		dishes.put("Sandwich", new String[] {"Cheese", "Bread"});
		dishes.put("Quesadilla", new String[] {"Chicken", "Cheese"});
		
		System.out.println(groupDishes(dishes));
	}

	static List<List<String>> groupDishes(Map<String, String[]> dishes) {
		List<List<String>> res = new ArrayList<>();

		if (dishes == null || dishes.size() == 0) {
			return res;
		}

		Map<String, List<String>> ingredientsMap = new HashMap<>();
		for (String dish : dishes.keySet()) {
			String[] ingredients = dishes.get(dish);

			for (String ingredient : ingredients) {
				if (!ingredientsMap.containsKey(ingredient)) {
					ingredientsMap.put(ingredient, new ArrayList<>());
				}
				ingredientsMap.get(ingredient).add(dish);

			}
		}

		for (String ingredient : ingredientsMap.keySet()) {
			if (ingredientsMap.get(ingredient).size() > 1) {
				res.add(ingredientsMap.get(ingredient));
			}
		}

		return res;
	}

}
