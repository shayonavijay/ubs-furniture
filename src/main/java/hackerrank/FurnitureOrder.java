package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
   
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
	
	private final Map<Furniture, Integer> furnitureTypeMap;
	

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
    	furnitureTypeMap = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
       
        if(furnitureTypeMap.containsKey(type)) {
        	furnitureTypeMap.put(type, furnitureTypeMap.get(type) + furnitureCount);
        } else {
        	furnitureTypeMap.put(type, furnitureCount);	
        }
        
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        
    	return new HashMap<Furniture, Integer>(furnitureTypeMap);
    }

    public float getTotalOrderCost() {
    	if(!furnitureTypeMap.isEmpty()) {
        	return furnitureTypeMap.entrySet().stream()
        			.map(f -> f.getKey().cost() * f.getValue())
        			.collect(Collectors.toList())
        			.stream()
        			.reduce(Float::sum)
        			.get();
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
    	if(furnitureTypeMap.containsKey(type)) {
        	return furnitureTypeMap.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
    	if(furnitureTypeMap.containsKey(type)) {
        	return furnitureTypeMap.get(type) * type.cost();
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        if(!furnitureTypeMap.isEmpty()) {
        	return furnitureTypeMap.values().stream().reduce(0, Integer::sum);
        }
        
        	return 0;
    }
}