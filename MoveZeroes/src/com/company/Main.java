package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i : nums)
            System.out.println(i + " ");
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length != 0)
        {
            for (int i=0; i<nums.length; i++)
                for (int j=i; j<nums.length; j++)
                {
                    if (nums[i]==0)
                        swap(nums, i, j);
                }

        }
    }

    public static void swap(int[] nums, int i, int j)
    {
        int swap = nums[j];
        nums[j] = nums[i];
        nums[i] = swap;
    }
}
