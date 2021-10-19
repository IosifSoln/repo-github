p = {2, 4, 6, 8, 10, 12}
q = {4, 8, 12, 116}
a = set()
count = 0
# 24
"""так как нам надо сумму элементов , то у нас
есть только 3 варианта решения в которой не будет бесконечной суммы
объединение двух множеств , их пересечение или разность  """


def f(x, a):
    return ((x in p) <= (((x in q) and (x not in a)) <= (x not in p)))


def obedinenie():
    setvar = p.union(q)
    flag = True
    k = 0
    for x in range(1, 1000):
        if not f(x, setvar):
            return False
    for i in setvar:
        k += i

    print(k)
    return True


def peresec():
    setvar = p & q
    flag = True
    k = 0
    for x in range(1, 1000):
        if not f(x, setvar):
            return False
    for i in setvar:
        k += i
    print(k)
    return True


def raznost():
    setvar = p.difference(q)
    flag = True
    k = 0
    for x in range(1, 1000):
        if not f(x, setvar):
            return False
    for i in setvar:
        k += i
    print(k)
    return True


if peresec():

    print('a')
elif obedinenie():
    print('b')

elif raznost():

    print('c')
