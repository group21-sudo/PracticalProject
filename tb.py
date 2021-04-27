import requests
import re

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1464.0 Safari/537.36',
    'Cookie': '网页登录后的Cookie'
}


def get_html(url):
    try:
        r = requests.get(url=url, timeout=10, headers=headers)
        r.encoding = r.apparent_encoding
        return r.text
    except:
        print("获取失败")


def get_data(html, goodlist):
    tlist = re.findall(r'\"raw_title\"\:\".*?\"', html)
    plist = re.findall(r'\"view_price\"\:\"[\d\.]*\"', html)
    nlist = re.findall(r'\"nick\"\:\".*?\"', html)
    for i in range(len(tlist)):
        title = eval(tlist[i].split(':')[1]) 
        price = eval(plist[i].split(':')[1])
        name = eval(nlist[i].split(':')[1])
        goodlist.append([title, price, name])

def write_data(list, num):
    with open("D:\list.txt", "w", encoding="utf-8") as f:
        for line in list:
            for item in line:
                f.write(item + "###")
            f.write("\n")


def main():
    goods = '编程实践'
    url = 'https://s.taobao.com/search?q=' + goods + '&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20210427&ie=utf8&sort=sale-desc'
    infoList = []
    html = get_html(url)
    get_data(html, infoList)
    print(len(infoList))
    print(infoList)
    write_data(infoList, len(infoList))

if __name__ == '__main__':
    main()
