/**
 * 66. ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
 *
 * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
 *
 * ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 *
 * ʾ��?1:
 *
 * ����: [1,2,3]
 * ���: [1,2,4]
 * ����: ���������ʾ���� 123��
 * ʾ��?2:
 *
 * ����: [4,3,2,1]
 * ���: [4,3,2,2]
 * ����: ���������ʾ���� 4321��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/plus-one
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                }
            }
        }
        return digits;
    }
}