import math

def clockwise(point):
    # Vector between point and the origin: v = p - o
    vector = [point[0]-origin[0], point[1]-origin[1]]
    # Length of vector: ||v||
    lenvector = math.hypot(vector[0], vector[1])
    # If length is zero there is no angle
    if lenvector == 0:
        return -math.pi, 0
    # Normalize vector: v/||v||
    normalized = [vector[0]/lenvector, vector[1]/lenvector]
    dotprod  = normalized[0]*refvec[0] + normalized[1]*refvec[1]     # x1*x2 + y1*y2
    diffprod = refvec[1]*normalized[0] - refvec[0]*normalized[1]     # x1*y2 - y1*x2
    angle = math.atan2(diffprod, dotprod)
    # Negative angles represent counter-clockwise angles so we need to subtract them 
    # from 2*pi (360 degrees)
    if angle < 0:
        return 2*math.pi+angle, lenvector
    # I return first the angle because that's the primary sorting criterium
    # but if two vectors have the same angle then the shorter distance should come first.
    return angle, lenvector

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
def distance(p1,p2):
    return math.sqrt((p2[0]-p1[0])**2+(p2[1]-p1[1])**2)
input2d=[]
f=open("input10.txt",'r')
for line in f:
    input2d.append(line)
lineLength=len(input2d[0].rstrip())
for i in range(len(input2d)): input2d[i]=input2d[i].rstrip()
input2d="".join(input2d)
#print(input2d)
    
lst=turnIntoArray(input2d,lineLength)
lstPoints=turnIntoPoints(lst)
print("NUMBER OF ASTEROID: " ,len(lstPoints))


#refvec = [0, 1]
refvec=[8,3]
#pts = [[2,3], [5,2],[4,1],[3.5,1],[1,2],[2,1],[3,1],[3,3],[4,3]]
pts=[(9, 0), (10, 0), (8, 1), (9, 1), (11, 1), (12, 1), (15, 1), (9, 2), (11, 2)]

#origin=(19,14)
origin=(19,14)
anglesDict={}
for point in lstPoints:
    ak=math.atan2(origin[1]-point[1],origin[0]-point[0])
    if ak not in anglesDict.keys(): anglesDict[ak]=[point]
    else: anglesDict[ak].append(point)
#print(anglesDict)
anglesClockwiseTmp=sorted(anglesDict.keys())
anglF=anglesClockwiseTmp[anglesClockwiseTmp.index(1.5707963267948966):]+sorted(anglesClockwiseTmp[:anglesClockwiseTmp.index(1.5707963267948966)],reverse=False)

i=0
while len(lstPoints)!=0:
    lstClosest=[]
    for k in anglF:
        if len(anglesDict[k])!=0:
            minPoint=anglesDict[k][0]
            minADist=distance(origin, anglesDict[k][0])
            for j in range(1,len(anglesDict[k])):
                if distance(origin,anglesDict[k][j])<minADist:
                    minADist=distance(origin,anglesDict[k][j])
                    minPoint=anglesDict[k][j]
            lstClosest.append(minPoint)
            #print(minPoint, anglesDict[k])
            anglesDict[k].remove(minPoint)
    for p in lstClosest:
        lstPoints.remove(p)
        i+=1
        print("Number of destroyed asteroid: " + str(i) + " : " + str(p))
                    

