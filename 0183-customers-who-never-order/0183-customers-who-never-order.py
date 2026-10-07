import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    filter=customers[~customers["id"].isin(orders["customerId"])]
    filter=filter[["name"]].rename(columns={"name":"Customers"})
    return filter