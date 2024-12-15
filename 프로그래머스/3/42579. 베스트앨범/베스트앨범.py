def solution(genres, plays):
    answer = []
    dic = {}
    counts = {}
    for i,(genre,play) in enumerate(zip(genres,plays)):
        if genre in dic:
            dic[genre].append((i,play))
        else:
            dic[genre] = [(i,play)]
        counts[genre] = counts.get(genre,0) + play
    
    sorted_genres = sorted(counts,key=lambda x: -counts[x])
    
    for genre in sorted_genres:
        sorted_songs = sorted(dic[genre],key=lambda x: (-x[1],x[0]))
        answer.extend([t[0] for t in sorted_songs[:2]])
    return answer