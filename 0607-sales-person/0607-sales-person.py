import pandas as pd

def sales_person(sales_person: pd.DataFrame, company: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    # Step 1: Find the com_id of the company named 'RED'
    red_company = company[company['name'] == 'RED']
    
    # Step 2: Merge Orders with the red_company to find orders related to 'RED'
    red_orders = orders.merge(red_company, on='com_id')
    
    # Step 3: Get a unique list of sales_ids who sold to 'RED'
    red_sales_ids = red_orders['sales_id'].unique()
    
    # Step 4: Filter out salespersons whose sales_id is in red_sales_ids
    result = sales_person[~sales_person['sales_id'].isin(red_sales_ids)]
    
    # Return only the 'name' column
    return result[['name']]