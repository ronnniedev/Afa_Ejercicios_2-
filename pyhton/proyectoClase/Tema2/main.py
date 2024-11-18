import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt


All_Penalies_Worldcup = pd.read_csv("C:\\Users\\mario\\OneDrive\\Desktop\\ProgramasSegundo\\pyhton\\proyectoClase\\Tema2\\Datos\\WorldCupShootouts.csv",sep=",")

# Le digo que todos los datos a tener en cuenta deben de tener todos los campos y la zona no debe ser nula
All_Penalies_Worldcup =  All_Penalies_Worldcup[All_Penalies_Worldcup['Zone'].notna()]
print(All_Penalies_Worldcup)
print(type(All_Penalies_Worldcup))

All_Penalies_Worldcup_Zones = All_Penalies_Worldcup.groupby(['Zone']).agg({'OnTarget': 'sum',
'Goal' : 'sum'})

print(All_Penalies_Worldcup_Zones)

All_Penalies_Worldcup_Zones['Efficiency'] = ((All_Penalies_Worldcup_Zones.Goal * 100)
                                             / All_Penalies_Worldcup_Zones.OnTarget)

ShootZonesEfficiency = All_Penalies_Worldcup_Zones['Efficiency']

ShootZonesPlotEfficiency = ShootZonesEfficiency.to_numpy().reshape(3,3)

print(ShootZonesPlotEfficiency)

ax = sns.heatmap(ShootZonesPlotEfficiency,vmin=0,vmax=100, annot=True,fmt=".2f",cmap="flare")
plt.show()

OnTarget = All_Penalies_Worldcup_Zones['OnTarget']

# Sumamos todos los penalties que se han realizado en zona y han ido a objetivo
allOnTarget = All_Penalies_Worldcup_Zones['OnTarget'].sum()

percentagePerZone = (OnTarget / allOnTarget) * 100

blockZonesPerZone = percentagePerZone.to_numpy().reshape(3,3)

# metemos el codigo cmap = flare para poder invertir los colores y que se vean similares a los de la pagina web
ax = sns.heatmap(blockZonesPerZone,vmin=0,vmax=30, annot=True,fmt=".2f",cmap="flare")
plt.show()

goalsPerPenaltieNumber = All_Penalies_Worldcup.groupby(['Penalty_Number']).agg({'Goal' : 'sum','Penalty_Number' : 'count'} )
# print(goalsPerPenaltieNumber)



print(goalsPerPenaltieNumber )

goalsPerPenaltieNumber['Porcentaje']= (goalsPerPenaltieNumber.Goal/goalsPerPenaltieNumber.Penalty_Number)*100

#Renombro el numero de penalty para que no haya conflicto a la hora de hacer los graficos de barras
goalsPerPenaltieNumber.rename(columns={"Penalty_Number": "Tiros"}, inplace=True)

print(goalsPerPenaltieNumber)

ax = sns.barplot(goalsPerPenaltieNumber,x="Penalty_Number", y="Porcentaje")
plt.show()

"""
Porcentaje de distribucion de tiros por zona
"""


'''
print(All_Penalies_Worldcup_Zones)

ShootZonesPlacement = All_Penalies_Worldcup_Zones['Placement']

ShootZonesPlotPlacement = ShootZonesPlacement.to_numpy().reshape(3,3)

# ax = sns.barplot()
'''
