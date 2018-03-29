# -*- coding: utf-8 -*-
"""
Created on Tue May 16 11:34:05 2017
/home/owe1_pg11/public_html/Mark/blast_resultaten.txt
'" + headers[c] + "'," + str(header_id[c]) + ")"
@author: Mark & Thijs
"""

import time
from Bio.Blast import NCBIWWW
from Bio.Blast import NCBIXML
from Bio import Entrez

ORFid = ""

def index():    #Deze functie wordt aangeroepen
    sequentie = automatisch()
    result_handle = blast(sequentie)    #functie voor blast aangeroepen
    blast_resultaat(sequentie,result_handle)  #functie voor resultaat verwerking aangeroepen

#Hieronder wordt de ingevoegde data van de champion compost verwerkt. de sequenties worden uitelkaar gehaald
#en vervolgens worden de header, quality_score en sequentie uitelkaar gehaalt
def automatisch():
    global ORFid
    bestand = open('seq.txt')
    lijst = bestand.read().split("[split]")
    ORFid = lijst[0]
    sequence = lijst[1]
    bestand.close()
    print(sequence)
    return sequence

#Hier wordt de blast uitgevoert netzolang er geen foutmelding voorkomt.
def blast(sequence, vorm = 'blastp'):
    try:
        time.sleep(5)
        result_handle = NCBIWWW.qblast(vorm, 'nr', sequence, expect=(1*(10**-5)), matrix_name='BLOSUM62', word_size=3, format_type='XML', hitlist_size=5)
        if vorm == 'blastp':
            return result_handle
        else:
            blast_records = NCBIXML.parse(result_handle)
            for blast_record in blast_records:
                return blast_record
    except:
        return blast(vorm, sequence)

def blast_resultaat(sequence, result):
    global ORFid
    z = 0
    data_lijst = []
    data = ""
    print("GG")
    blast_records = NCBIXML.parse(result)   #De resultaten woorden doorgelezen
    for blast_record in blast_records:
        for alignment in blast_record.alignments:
            for hsp in alignment.hsps:
                if z != 5: #controle zodat er max 10 resultaten worden opgeslagen
                    naam, organisme, taxonomie, beschrijving, comment = ncbi_entrez(alignment.accession) #aanroeping van ncbi entrez
                    data += (alignment.accession+'[split]'+str(hsp.expect)+'[split]'+str(hsp.score)+
                             '[split]'+naam+'[split]'+organisme+'\n\n')
                    z += 1
                    data_lijst.append(data)
                    data=""
    file = open("result.txt",'w')
    file.write(ORFid+"\n\n")
    for x in data_lijst:
        file.write(x)
    file.write(str(len(data_lijst)))
    file.close()
    print("Done")
    print(len(data_lijst))
                       
#Hier wordt de NCBI entrez database aangeroepen met een accessienummer
#Vervolgens wrodten de onderdelen geselecteerd en teruggestuurd naar blast_resultaten.   
def ncbi_entrez(accessiecode):
    try:
        time.sleep(5)
        Entrez.email = "mark-de-korte@hotmail.nl"
        handle = Entrez.efetch(db="protein", id=accessiecode, rettype="gb", retmode="xml")
        records = Entrez.parse(handle)
        for record in records:
            naam = '%'
            if record.get('GBSeq_definition') != None:
                naam = record['GBSeq_definition']
            organisme = '%'
            if record.get('GBSeq_organism') != None:
                organisme = record['GBSeq_organism']
            taxonomie = '%; %'
            if record.get('GBSeq_taxonomy') != None:
                taxonomie = record['GBSeq_taxonomy']
                if taxonomie.count('; ') == 0:
                    taxonomie = 'Unclassified.; Unclassified.'
            comment = '%'
            if record.get('GBSeq_comment') != None:
                comment = record['GBSeq_comment']
            beschrijving = '%'
            if record.get('GBSeq_references') != None:
                beschrijving = record['GBSeq_references'][0]['GBReference_title']
            return naam, organisme, taxonomie, beschrijving, comment
    except:
        return ncbi_entrez(accessiecode)

index()