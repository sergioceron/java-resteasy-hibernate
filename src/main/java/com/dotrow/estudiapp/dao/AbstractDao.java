package com.dotrow.estudiapp.dao;

import com.dotrow.estudiapp.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractDao<T> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected Class<T> clazz;

    public AbstractDao( Class<T> clazz ) {
        this.clazz = clazz;
    }

    public Class<T> getClazz() {
        return this.clazz;
    }

    public void setClazz( Class<T> clazz ) {
        this.clazz = clazz;
    }

    public List<T> findAll() {
        List<T> entities = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery( "from " + this.clazz.getSimpleName() + " e" );
            entities = query.list();
            session.getTransaction().commit();
        } catch( Exception exception ) {
            if( session != null ) {
                session.getTransaction().rollback();
            }
        } finally {
            if( session != null ) {
                session.close();
            }
        }

        return entities;
    }

    public T get( Long id ) {
        T entity = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery( "from " + this.clazz.getSimpleName() + " e where e.id = :ID" );
            query.setParameter( "ID", id );
            entity = (T) query.uniqueResult();
            Hibernate.initialize( entity );
            session.getTransaction().commit();
        } catch( Exception exception ) {
            if( session != null ) {
                session.getTransaction().rollback();
            }
        } finally {
            if( session != null ) {
                session.close();
            }
        }

        return entity;
    }

    public boolean create( T entity ) {
        Boolean success = false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist( entity );
            session.getTransaction().commit();
            success = true;
        } catch( Exception exception ) {
            if( session != null ) {
                session.getTransaction().rollback();
            }
        } finally {
            if( session != null ) {
                session.close();
            }
        }

        return success;
    }

    public boolean update( T entity ) {
        Boolean success = false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.merge( entity );
            session.getTransaction().commit();
            success = true;
        } catch( Exception exception ) {
            if( session != null ) {
                session.getTransaction().rollback();
            }
        } finally {
            if( session != null ) {
                session.close();
            }
        }

        return success;
    }

    public boolean delete( T entity ) {
        Boolean success = false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete( entity );
            session.getTransaction().commit();
            success = true;
        } catch( Exception exception ) {
            if( session != null ) {
                session.getTransaction().rollback();
            }
        } finally {
            if( session != null ) {
                session.close();
            }
        }

        return success;
    }

}
