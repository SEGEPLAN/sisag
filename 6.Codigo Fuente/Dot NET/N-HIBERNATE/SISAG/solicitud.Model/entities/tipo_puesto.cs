using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class tipo_puesto
    {
        private string _ID;
        private string _NOMBRE;
        private string _DESCRIPCION;
        private int _ESTADO;
        private IList<necesidad_puesto> _NECESIDAD = new List<necesidad_puesto>();
        private IList<usuario> _USUARIO = new List<usuario>();
        private unidad_administrativa _UNIDAD_ADMINISTRATIVA;
        

        public tipo_puesto()
        {
            throw new System.NotImplementedException();
        }

        public tipo_puesto(string pID, string pNombre, string pDescripcion, string pEstado)
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

        public IList<necesidad_puesto> NECESIDAD
        {
            get { return _NECESIDAD; }
            set { _NECESIDAD = value; }
        }

        public unidad_administrativa UNIDAD_ADMINISTRATIVA
        {
            get { return _UNIDAD_ADMINISTRATIVA; }
            set { _UNIDAD_ADMINISTRATIVA = value; }
        }

        public IList<usuario> USUARIO
        {
            get { return _USUARIO; }
            set { _USUARIO = value; }
        }

        public Boolean Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public tipo_puesto RecuperarObjetos(string pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<tipo_puesto> RecuperarObjetos()
        {
            throw new System.NotImplementedException();
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public IList<tipo_puesto> recuperarTipo_puesto(unidad_administrativa pUA)
        {
            throw new System.NotImplementedException();
        }
    }
}
