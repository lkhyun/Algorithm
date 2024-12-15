def solution(phone_book):
    phone_book.sort()
    for index in range(len(phone_book)-1):
        if phone_book[index+1].startswith(phone_book[index]):
            return False
    return True