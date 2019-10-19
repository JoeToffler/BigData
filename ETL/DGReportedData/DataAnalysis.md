## 背景
List中Object数据解析处理通用模型
## 核心代码    
    /**
     * 数据项由统一分隔符$分开,换行符号统一为\r\n
     *
     * @param clazz   解析类
     * @param ts      解析数据
     * @param c       替换字符
     * @param lc      换行替换的字符
     * @param lastKey 最后key的name
     * @return 解析后的数据
     */
    public static <T> List<T> convert(Class clazz, List<T> ts, String c, String lc, String lastKey) {
        ArrayList<T> list = new ArrayList<>();
        String set = "set";
        String get = "get";
        ts.forEach(t -> {
            Method[] methods = clazz.getMethods();
            Arrays.stream(methods).forEach(method -> {
                if (method.getName().startsWith(set)) {
                    try {
                        Method methodGet = clazz.getMethod(StringUtils.replace(method.getName(), set, get), null);
                        String getStr = "";
                        //如果报NullPointException则getStr=""
                        try {
                            getStr = methodGet.invoke(t, null).toString();
                            //判断是否有字符需要替换
                            getStr = replaceSymbol(getStr);
                        } catch (NullPointerException e) {
                        }
                        if (!method.getName().contains(lastKey)) {
                            getStr = getStr + c;
                            method.invoke(t, getStr);
                        } else {
                            getStr = getStr + c + lc;
                            method.invoke(t, getStr);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(t);
        });
        return list;
    }
