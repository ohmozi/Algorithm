# 균형잡힌 세상
while (1):
    stack = [0, 0]
    st = []
    string = input()
    flag = True
    if string == '.':
        break
    for char in string:
        if char == '(':
            st.append('(')
            stack[0] += 1
        elif char == ')':
            if len(st) == 0:
                flag = False
                break
            temp = st.pop(-1)
            if temp == '[':
                flag = False
                break
            stack[0] -= 1
        elif char == '[':
            st.append('[')
            stack[1] += 1
        elif char == ']':
            if len(st) == 0:
                flag = False
                break
            temp = st.pop(-1)
            if temp == '(':
                flag = False
                break
            stack[1] -= 1
        else:
            continue

        if stack[0] < 0 or stack[1] < 0:
            break

    if stack[0] == 0 and stack[1] == 0 and flag:
        print("yes")
    else :
        print("no")
