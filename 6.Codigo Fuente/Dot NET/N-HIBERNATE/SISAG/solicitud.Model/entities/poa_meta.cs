using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class poa_meta
    {
        private string _ID;
        private string _NOMBRE;
        private IList<tema_curso> _TEMA_CURSO = new List<tema_curso>();

        public poa_meta()
        {
            throw new System.NotImplementedException();
        }

        public poa_meta(string pID)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public string NOMBRE
        {
            get { return _NOMBRE; }
            set { _NOMBRE = value; }
        }

        public IList<tema_curso> TEMA_CURSO
        {
            get { return _TEMA_CURSO; }
            set { _TEMA_CURSO = value; }
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public void Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public poa_meta recuperarObjeto(string pID)
        {
            throw new System.NotImplementedException();
        }

        public void recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }
    }
}
