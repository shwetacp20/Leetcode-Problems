import pandas as pd

def find_managers(employee: pd.DataFrame) -> pd.DataFrame:
    # Step 1: Count occurrences of each managerId
    manager_counts = employee['managerId'].value_counts()
    
    # Step 2: Filter managers who have at least 5 reports
    valid_managers = manager_counts[manager_counts >= 5].index
    
    # Step 3: Filter the employee table to get the names of these managers and return as a DataFrame
    result = employee[employee['id'].isin(valid_managers)][['name']]
    
    return result