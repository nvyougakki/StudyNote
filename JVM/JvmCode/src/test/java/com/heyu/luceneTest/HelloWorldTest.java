package com.heyu.luceneTest;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author heyu
 * @Date 2021/1/21 14:54
 * @Package com.heyu.luceneStudy
 * @Description
 **/
public class HelloWorldTest {

    private String doc1 = "hello world";
    private String doc2 = "hello java world";
    private String doc3 = "hello lucene world";

    @Test  //索引的创建:IndexWriter
    public void testIndexWriter() throws  Exception{
        Path path = Paths.get("F:\\lucene\\index\\_01_helloworld");
        Directory d = FSDirectory.open(path);//索引存放的目录
        Analyzer analyzer = new SimpleAnalyzer();//分词器
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);//配置对象
        //1 创建核心对象IndexWriter
        IndexWriter indexWriter = new IndexWriter(d,conf);

        //2 使用IndexWriter为全文创建索引
        Document document1 = new Document();
        document1.add(new TextField("title","doc1", Field.Store.YES));
        document1.add(new TextField("content",doc1, Field.Store.YES));
        indexWriter.addDocument(document1);

        Document document2 = new Document();
        document2.add(new TextField("title","doc2", Field.Store.YES));
        document2.add(new TextField("content",doc2, Field.Store.YES));
        indexWriter.addDocument(document2);

        Document document3 = new Document();;
        document3.add(new TextField("title","doc3", Field.Store.YES));
        document3.add(new TextField("content",doc3, Field.Store.YES));
        indexWriter.addDocument(document3);

        indexWriter.commit();
        indexWriter.close();

    }

    @Test //索引的搜索:IndexSearcher
    public void testIndexSearcher() throws Exception{
        Path path = Paths.get("F:\\lucene\\index\\_01_helloworld");
        Directory d = FSDirectory.open(path);//索引存放的目录
        //索引的读的对象
        IndexReader indexReader = DirectoryReader.open(d);
        //1 创建索引查询对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //2 执行查询操作
        String f = "content";//默认查询的字段
        Analyzer a = new SimpleAnalyzer();//分词器,注意创建索引的分词器和搜索索引的分词器要保持一致
        QueryParser queryParser = new QueryParser(f,a);
        String queryStr = "content:java world";//查询字符串
        Query query = queryParser.parse(queryStr);
        int numHits = 10;//最大命中的条数
        TopDocs topDocs = indexSearcher.search(query, numHits);//查询,返回查询结果

        //3 分析查询结果
        int totalHits = topDocs.totalHits;//命中的条目数,总条目数
        System.out.println("总共命中:"+totalHits);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//返回命中的所有的数据
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;//返回命中文档的id
            //System.out.println(doc);
            Document document = indexSearcher.doc(doc);
            String title = document.get("title");
            String content = document.get("content");
            System.out.println("title:"+title+";content:"+content);
        }
        //4 释放资源
        indexReader.close();
    }

}
