import pandas as pd

def find_products(products: pd.DataFrame) -> pd.DataFrame:
    find_products_filter=(products["low_fats"]=="Y")&(products["recyclable"]=="Y")
    return products.loc[find_products_filter,["product_id"]]
    