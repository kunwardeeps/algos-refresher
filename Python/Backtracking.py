def permute(nums):
    output = []
    permute_helper(nums, output, 0)
    return output

def permute_helper(nums, output, first):
    n = len(nums)
    if first == n:
        output.append(nums[:])
    for i in range(first, n):
        nums[first], nums[i] = nums[i], nums[first]
        permute_helper(nums, output, first + 1)
        nums[first], nums[i] = nums[i], nums[first]

print(permute([1, 2, 3]))