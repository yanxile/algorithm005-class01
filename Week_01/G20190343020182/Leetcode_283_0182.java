package week001;

/*
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ��:

����: [0,1,0,3,12]
���: [1,3,12,0,0]
˵��:

������ԭ�����ϲ��������ܿ�����������顣
�������ٲ���������


��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/move-zeroes
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class Leetcode_283_0182 {
    public void moveZeroes(int[] nums) {
        int j = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != 0)
    		{
    			nums[j] = nums[i];
    			if (i != j) {
    				nums[i] = 0;
    			}
    			j++;
    		}
    	}
    }
}
