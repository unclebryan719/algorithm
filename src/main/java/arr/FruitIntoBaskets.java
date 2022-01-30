package arr;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2){
            return fruits.length;
        }
        int count = 0;
        int left = 0;
        for(int right = 2; right < fruits.length; right++){
            if(fruits[right] == fruits[right - 1] || fruits[right] == fruits[left]){
                count = Math.max(count, right - left + 1);
                while (fruits[left] != fruits[right] && fruits[left] != fruits[right-1]){
                    left ++;
                }
            }
        }
        return count == 0 ? fruits.length : count;
    }
}
