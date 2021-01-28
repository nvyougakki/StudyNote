package com.heyu.luceneTest;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author heyu
 * @Date 2021/1/21 15:15
 * @Package com.heyu.luceneTest
 * @Description
 **/
public class FieldTest {

    private String doc1 = "何宇";
    private String doc2 = "何宇是你吧";
    private String doc3 = "hello lucene world";
    private String doc4 = "hello lucene java world";

    @Test //索引的创建:IndexWriter
    public void testIndexWriter() throws  Exception{
        Path path = Paths.get("F:\\lucene\\index\\_02_field");
        Directory d = FSDirectory.open(path);//索引存放的目录
        Analyzer analyzer = new SimpleAnalyzer();//分词器
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);//配置对象
        //1 创建核心对象IndexWriter
        IndexWriter indexWriter = new IndexWriter(d,conf);
        //2 使用IndexWriter为全文创建索引
        Document document1 = new Document();
        FieldType type = new FieldType();
        type.setStored(true);//该字段的值是否存储
        type.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);//索引的类型
        type.setTokenized(false);//是否分词
        document1.add(new Field("title","doc1",type));
        document1.add(new Field("content",doc1,type));
//        document1.add(new TextField("title","doc1", Field.Store.YES));
//        document1.add(new TextField("content",doc1, Field.Store.YES));
        indexWriter.addDocument(document1);

        indexWriter.commit();
        indexWriter.close();
    }

    @Test //索引的搜索:IndexSearcher
    public void testIndexSearcher() throws Exception{
        Path path = Paths.get("F:\\lucene\\index\\_02_field");
        Directory d = FSDirectory.open(path);//索引存放的目录
        //索引的读的对象
        IndexReader indexReader = DirectoryReader.open(d);
        //1 创建索引查询对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //2 执行查询操作
        PhraseQuery.Builder builder = new PhraseQuery.Builder();
        builder.add(new Term("content","何宇"));
        Query query = builder.build();
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
