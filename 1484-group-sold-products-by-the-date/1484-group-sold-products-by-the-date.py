import pandas as pd

def categorize_products(activities: pd.DataFrame) -> pd.DataFrame:
    df=activities.drop_duplicates().sort_values(by=["sell_date","product"])
    result=(df.groupby("sell_date")["product"].agg(
        num_sold="nunique",
        products=lambda x:",".join(x)
    ).reset_index()
    )
    return result