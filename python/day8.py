
def checkColorAtI(lst2d,i):
    color=2
    j=0
    while color==2:
        color=lst2d[j][i]
        j+=1
    return color
def stackLayer(layers, dim):
    decoded=[]
    for i in range(dim):
        decoded.append(checkColorAtI(layers,i))
    msg="".join(map(str,decoded))
    return msg
def decode(s):
    s2=""
    for c in s:
        if c=='0': s2+='B'
        if c=='1': s2+='W'
    return s2
f=open("input8","r")
listLayers=[]
layer=[]
for line in f:
    for c in line:
        layer.append(int(c))
        if len(layer)==(25*6):
            listLayers.append(layer)
            layer=[]
minCount=151
for l in listLayers:
    tempCount=l.count(0)
    if tempCount<minCount:
        minCount=tempCount
        minLayer=l
print(minLayer.count(1)*minLayer.count(2))

testA=[[0,2,2,2],[1,1,2,2],[2,2,1,2],[0,0,0,0]]
print(decode(stackLayer(testA,len(testA[0]))))
santaMSG=decode(stackLayer(listLayers,len(listLayers[0])))
l=""
for i in range(len(santaMSG)):
    l+=santaMSG[i]
    if len(l)==25:
        print(l)
        l=""
    

