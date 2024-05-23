package BarkingDog.YouTube_14_Sort_1;

/*
퀵 소트가 거의 모든 정렬 알고리즘보다 빨라서 각종 라이브러리의 정렬은 대부분 퀵 소트를 바탕으로 만들어져 있다.
코테에서는 퀵 소트를 사용x 머지 소트를 사용 이유는,,?

퀵 소트도 머지 소트처럼 재귀적으로 구현되는 정렬이다.
퀵 소트에서는 매 단계마다 pivot이라고 이름 붙은 원소 하나를 제자리로 보내는 작업을 반복한다.

6 -8 1 12 8 3 7 -7 원소를 가지는 리스트가 있다.

pivot은 보통 제일 왼쪽 원소부터 시작한다.
pivot을 제자리로 넣고 싶다. == > 오른쪽은 pivot보다 큰 원소들이 왼쪽은 pivot보다 작은 원소들이

제일먼저 pivot이 6이면
1. 3 -8 1 -7 6 8 7 12 이런식으로

1. 같이 할려면 간단하다
임시 배열 tmp를 만들고
tmp에 pivot 보다 작은 수를 넣는다. -8 1 3 -7 이다.
그 다음 pivot을 넣고
나머지에는 남은 수들을 넣는다.

퀵소트의 장접은 추가적인 공간이 필요하지 않다는 점에 있다.
배열 안에서의 자리 바꿈만으로 처리가 되기 떄문에 cache hit rate가 높아서 속도가 빠르다는 장점도 따라오는 거다.
이렇게 추가적인 공간을 사용하지 않는 정렬을 In Place Sort라고 부른다.

다시
6 -8 1 12 8 3 7 -7 에서 pivot이 6인 경우부터 시작한다.

양쪽 끝에 포인터 2개를 놓고 적절하게 스왑을 한다. l,r

l = -8의 idx
r = -7의 idx

l은 pivot보다 큰 값이 나올 때까지 오른쪽으로 이동한다.
r은 pivot보다 작거나 같은 값이 나올 때 까지 왼쪽으로 이동한다.

그 다음 두 포인터가  가리키는 원소 값을 스왑한다. 이걸 l과 r이 교차할 때 까지 반복한다.

그럼
6 -8 1 12 8 3 7 -7 에서 동작을 하면 l은 12에 r은 -7에 있다. 두 값을 스왑한다.
-> 6 -8 1 -7 8 3 7 12

다시 반복
l을 오른쪽으로 이동
r은 왼쪽으로 이동

그럼 l은 8에서 멈추고 r은 3멈춘다 둘이 스왑
-> 6 -8 1 -7 3 8 7 12

r이 l보다 작아진 순간이 오면 pivot과 r을 스왑하면서 알고리즘이 끝난다.

시간복잡도는 평균적으로 O(NlhN)이지만 최악의 경우 O(N^2)이다. ( 1, 2, 3, 4, 5, 6, 7, 8)을 정렬하는 경우
머지 소트를 코테어서 퀵 소트 대신 쓰는 이유는 최악의 경우를 피하기 위해서 ㅇㅇ
 */

/*
cache hit rate란?
캐시(Cache) 메모리에 저장된 데이터 중에서 요청된 데이터의 비율을 나타내는 지표입니다.
캐시는 CPU와 메인 메모리 사이에 위치하여 빠른 액세스 속도를 제공하는 작은 용량의 메모리입니다.
캐시 히트 비율은 캐시에 저장된 데이터 중에서 요청된 데이터가 캐시에 존재하는 비율을 나타냅니다.
즉, 요청된 데이터가 캐시에 있는 경우를 "캐시 히트(cache hit)"라고 하고,요청된 데이터가 캐시에 없어서 메인 메모리에서 가져와야 하는 경우를 "캐시 미스(cache miss)"라고 합니다.

 */


import java.util.Arrays;

public class Quick_Sort {
    static  int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
    public static void main(String[] args) {
        int n = arr.length;
        quickSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }
    public static int partition(int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {
            System.out.println(Arrays.toString(arr));
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(i, j);
            }
        }
        swap(low, j);
        return j;
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
