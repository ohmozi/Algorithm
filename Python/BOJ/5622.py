dial = input()
nums = []

for d in dial:
    if d in ['A', 'B', 'C']:
        nums.append(3)
    elif d in ['D','E', 'F']:
        nums.append(4)
    elif d in ['G', 'H', 'I']:
        nums.append(5)
    elif d in ['J', 'K', 'L']:
        nums.append(6)
    elif d in ['M', 'N', 'O']:
        nums.append(7)
    elif d in ['P', 'Q', 'R', 'S']:
        nums.append(8)
    elif d in ['T', 'U', 'V']:
        nums.append(9)
    elif d in ['W', 'X', 'Y', 'Z']:
        nums.append(10)
    else:
        nums.append(11)

print(sum(nums))