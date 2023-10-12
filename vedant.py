import scrapy

import pandas as pd


class BunnycartSpider(scrapy.Spider):

 name = 'bunnycart'


 def start_requests(self):

    start_urls = ['https://www.bunnycart.com/aquarium-plants']


    for url in start_urls:

        yield scrapy.Request(url=url, callback=self.parse)



 def parse(self, response):

 # Select the <ol> element containing the list of products

    element = response.xpath("/html/body/div[1]/main/div[4]/div[1]/div[4]")

    ol = element.xpath('//ol[contains(@class, "filterproducts products list items product-items has-qty")]')



    cleaned_names = []

    clean_prices = []

    ratings = []



    for li in ol:

        names = li.xpath("li/div/div[2]/strong/a/text()").getall()

        cleaned_names.extend([name.strip() for name in names if name.strip()])



    price_span = li.xpath("li/div/div[2]/div[2]//span[@class='price']")

    clean_prices = price_span.xpath(".//text()").getall()



    ratings = li.xpath("li/div/div[2]/div[1]/div/div/span/span/text()").getall()



    for name, price, rating in zip(cleaned_names, clean_prices, ratings):

 # print("name =", name)

# print("price =", price)

# print("ratings =", rating)

 # print("-------")



        pass # Add this line to keep the indentation correct



# Create a DataFrame

    data = {

 'Name': cleaned_names,

 'Price': clean_prices,

'Ratings': ratings

 }
    df = pd.DataFrame(data)

    print(df)