package programmers.truck_pass_bridge;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        int current_weight = 0;
        for(int truck : truck_weights)
        {
            while(true){
                if(bridge.isEmpty()){
                    bridge.offer(truck);
                    answer++;
                    current_weight+=truck;
                    break;
                }else if(bridge.size() == bridge_length){
                    current_weight-=bridge.poll();
                }else if(current_weight + truck <= weight){
                    bridge.offer(truck);
                    answer++;
                    current_weight+=truck;
                    break;
                }else{
                    bridge.offer(0);
                    answer++;
                }
            }
        }
        
        return answer + bridge_length;
    }
}

/*

1. Queue<Integer> bridge

2. �ٸ��� ���������, truck �ϳ��� ���Ը� �ø���.

3. Ʈ���� �� ����������, Queue�� ũ��� �ٸ��� ���̿� ��������.

   Ʈ�� �ϳ��� ���Ը� ����.

4. �ٸ��� ������� �ʰ�, ���� ���Կ� Ʈ�� �ϳ��� ���� ���� �ִ����ߺ��� �۰ų� ���� ��, Ʈ�� �ϳ��� �ø���.

5. �ٸ��� ������� �ʰ�, ���԰� �ʰ��� �� 0�� �ִ´�.
 
*/
