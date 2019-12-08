import re
def adjacent(lst):
        inv=False
        for i in range(len(lst)-1):
                if lst[i]==lst[i+1]:
                        if i+2<len(lst):
                                if lst[i]==lst[i+2]: inv=False
                                else: inv=True
                        else: inv=True
                if inv: break
        return inv
#def regexSol1(s):
#        l=re.findall(r"([0-9])\1",s)
#        for c in l:
def reg2(s):
        subseqs=[item[0] for item in re.findall(r"((.)\2*)", s)]
        for n in subseqs:
                if len(n)==2: return True
        return False
def findOccurance(s):
        for i in range(0,10):
               subseq=str(i)+str(i)
               if s.count(subseq)>0: return True
        return False
def found(i):
        lst=list(map(int,str(i)))
        lstStr=str(i)
        return sorted(lst)==lst and reg2(lstStr)
        #return sorted(lst)==lst and adjacent(lst)
count=0
print(found(111111))
print(found(223450))
print(found(123789))
print(found(112233))
print(found(123444))
print(found(111122))

for i in range(264793,803935+1):
        if found(i):
                count+=1
                print(count, " ",i)
        i+=1
#835 wrong
        
