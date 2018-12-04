This Utility project helps to produce the minimum number of Zip Code ranges
required to represent the same restrictions as the input.

For eg)

 If the input  is {94133,94133} {94200,94299} {94600,94699}
 Then the output should be = {94133,94133} {94200,94299} {94600,94699}

If the input = {94133,94133} {94200,94299} {94226,94399} 
Then the output should be = {94133,94133} {94200,94399}

How it works?

After getting the array of inputs, sort the array based on the start range in the ascending order. Then push the first element to the stack. Check for end range of the element in the stack is greater than the start range of next element in the array and end range is less than end range in next element in the array. If so, pop the element from the stack, add the next element end range as the end range to the element which is popped and push it to the stack and this process continues. Else if the previously mentioned condition is not met, just push the element to the stack.

