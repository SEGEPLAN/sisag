using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class tema_curso
    {
        private string _ID;
        private string _NOMBRE;
        private string _DESCRIPCION;
        private poa_meta _POA_META;
        private IList<detalle_necesidad> _DETALLE_NECESIDAD = new List<detalle_necesidad>();
        private int _ESTADO;

        public tema_curso()
        {
            throw new System.NotImplementedException();
        }

        public tema_curso(string pID, string pNombre, string pDescripcion, int pEstado)
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

        public string DESCRIPCION
        {
            get { return _DESCRIPCION; }
            set { _DESCRIPCION = value; }
        }

        public poa_meta POA_META
        {
            get { return _POA_META; }
            set { _POA_META = value; }
        }

        public IList<detalle_necesidad> DETALLE_NECESIDAD
        {
            get { return _DETALLE_NECESIDAD; }
            set { _DETALLE_NECESIDAD = value; }
        }

        public int ESTADO
        {
            get { return _ESTADO; }
            set { _ESTADO = value; }
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public tema_curso recuperarObjeto(string pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<tema_curso> recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }

        public IList<tema_curso> recuperarTema_detalle(detalle_necesidad pDetalle)
        {
            throw new System.NotImplementedException();
        }

        public IList<tema_curso> recuperarTema_meta(poa_meta pMeta)
        {
            throw new System.NotImplementedException();
        }
    }
}
