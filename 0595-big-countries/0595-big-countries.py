import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    big_countries_filter=(world["area"]>=3000000)| (world["population"]>=25000000)
    return world.loc[big_countries_filter,["name","population","area"]]

    