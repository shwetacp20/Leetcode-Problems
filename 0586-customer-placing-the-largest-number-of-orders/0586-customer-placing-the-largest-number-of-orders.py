import pandas as pd

def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    if orders.empty:
        return pd.DataFrame(columns=['customer_number'])
        
    df = orders.groupby('customer_number').size().reset_index(name='count')
    
    result = df.nlargest(1, 'count')[['customer_number']]
    
    return result