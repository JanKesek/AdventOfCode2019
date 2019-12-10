import math

def turnIntoArray(s,n):
    lst2d=[]
    lst=[]
    for i in range(len(s)+1):
        if len(lst)==n:
            lst2d.append(lst)
            lst=[]
        if i!=len(s): lst.append(s[i])
    return lst2d
def turnIntoPoints(arr):
    lst=[]
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if arr[i][j]=='#': lst.append((j,i))
    return lst
input2d=[]
f=open("input10.txt",'r')
for line in f:
    input2d.append(line)
lineLength=len(input2d[0].rstrip())
for i in range(len(input2d)): input2d[i]=input2d[i].rstrip()
input2d="".join(input2d)
print(input2d)
    
lst=turnIntoArray(input2d,lineLength)
lstPoints=turnIntoPoints(lst)
print(lstPoints)
minPoint=(3,4)
ak=math.atan2(minPoint[1],minPoint[0])
lstNeighbors=[]
for point in lstPoints:
    dictOfAngles={}
    for point2 in lstPoints:
        if point!=point2:
            angle=math.atan2(point2[1]-point[1],point2[0]-point[0])
            dictOfAngles[angle]=[point,point2]
    lstNeighbors.append([len(dictOfAngles),point])
print(max(lstNeighbors))
