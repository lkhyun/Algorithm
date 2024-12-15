def solution(sizes):
    w = 0
    h = 0
    for size in sizes:
        if max(size) > w:
            w = max(size)
        if min(size) > h:
            h = min(size)
    return w*h