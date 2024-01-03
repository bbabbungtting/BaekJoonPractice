import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(calcuteMean(arr));

        System.out.println(arr[N/2]);

        System.out.println(findMode(arr));

        System.out.println(arr[N-1] - arr[0]);
    }

    public static int calcuteMean(int[] arr){
        double sum = Arrays.stream(arr).sum();
        double mean = sum / arr.length;

        if(mean<0.0){
            return (int)Math.round(Math.abs(mean)*-1);
        }
        else{
            return (int)Math.round(mean);
        }
    }

    public static int findMode(int[] arr) {
        Map<Integer, Long> frequencyMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        long maxFrequency = frequencyMap.values().stream()
                .max(Long::compare)
                .orElseThrow();

        if (frequencyMap.values().stream().filter(freq -> freq == maxFrequency).count() > 1) {
            int result = frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxFrequency)
                    .map(Map.Entry::getKey)
                    .sorted()
                    .skip(1)
                    .findFirst()
                    .orElseThrow();
            return result;
        } else {
            return frequencyMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElseThrow();
        }
    }
}