#%%
import os
from bs4 import BeautifulSoup
import pandas as pd
import numpy as np

# List the path
path = "/Users/alex/Python/datasets/10000_jobs_ads"

html_list = os.listdir(path)
#set load batch size & data size
batch_size = 100
data_size = 100
if len(html_list)<(data_size):
    error = True
else:
    error = False

#%%
# load html data and insert all scripts in content_list object, by page
def loadHtml(x,y):

    path_list = np.array([])
    content_list = np.array([])
    times=0    
        
        
            
    for i in x:
        i_path = os.path.join(y,i)
        # Open html file
        with open(i_path, 'r',encoding="utf-8") as page:
            content_list=np.append(content_list,page.read())
        times+=1
        print("page loaded", times)
            
    print("all page loaded")
    return content_list

#%%
# extract html as string to list, insert content_list , call by getRequirement() or getEducation()
class extract_html_to_list():
    
    def __init__(self, x):
        self.content_list = x
        

    # Extract "Requirement" tag from html, each row = one page
    def getRequirement(self):
        job_body_list = np.array([])
        for i in self.content_list:
            soup = BeautifulSoup(i, "lxml")
            soup_screened = soup.find("div", id = "job-body")
            if soup_screened != None:
                job_body_list = np.append(job_body_list, soup_screened.get_text())
            else:
                job_body_list = np.append(job_body_list, "N/A")
        print("requirement loaded")  
        return job_body_list
        
    # Extract "Education" tag from html, each row = one page
    def getEducation(self):
        job_edu_list = np.array([])
        for i in self.content_list:
            soup = BeautifulSoup(i, "lxml")
            soup_screened = soup.find("td", class_="jd-education")
            if soup_screened != None:
                job_edu_list = np.append(job_edu_list, soup_screened.get_text())
            else: 
                job_edu_list = np.append(job_edu_list, "N/A")
        print("education loaded")
        return job_edu_list

#%%
# Put them in dataset
def getFinalData(x):
    
    requirement_df = pd.DataFrame(extract_html_to_list(x).getRequirement())
    
    education_df = pd.DataFrame(extract_html_to_list(x).getEducation())
    
    dataset = pd.concat([requirement_df,education_df], axis=1)
    dataset.columns = ['Requirements', 'Education']
    print("all loaded")

        
    return dataset
#%%
#insert dataframe in function
def write_to_excel(x):
    # create excel writer object
    writer = pd.ExcelWriter('Job_Dataset.xlsx')
    # write dataframe to excel
    x.to_excel(writer)
    # save the excel
    writer.save()
    print('The final data is written successfully.')
#%%
if error == False:
    finaldata = pd.DataFrame({'Requirements':[], 'Education':[]})
    temp=0
    for i in range(batch_size, data_size, batch_size):
        finaldata = pd.concat([finaldata,getFinalData(loadHtml(html_list[temp:i],path))])
        print("cycle's html number =",i)
        temp+=batch_size
        if (i+batch_size) > data_size:
            finaldata = pd.concat([finaldata,getFinalData(loadHtml(html_list[i:data_size],path))])
            print("last cycle")
    write_to_excel(finaldata)
    
else:
    print("data_size bigger than number of html")

